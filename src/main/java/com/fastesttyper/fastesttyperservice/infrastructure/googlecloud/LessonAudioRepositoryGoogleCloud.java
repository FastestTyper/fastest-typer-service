package com.fastesttyper.fastesttyperservice.infrastructure.googlecloud;

import com.fastesttyper.fastesttyperservice.domain.model.Lesson;
import com.fastesttyper.fastesttyperservice.domain.repositories.LessonAudioRepository;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.texttospeech.v1beta1.*;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Component;

@Component
public class LessonAudioRepositoryGoogleCloud implements LessonAudioRepository {
    private final Storage storage = StorageOptions.getDefaultInstance().getService();

    @Override
    public boolean existAudio(Lesson lesson) {
        Page<Blob> blobs = storage.list("fastesttyper");

        for (Blob blob : blobs.iterateAll()) {
            if(blob.getName().equals(lesson.getId() + ".mp3")) return true;
        }
        return false;
    }

    public String createAudio(Lesson lesson) {
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            SynthesisInput input = SynthesisInput.newBuilder()
                    .setText(lesson.getText())
                    .build();

            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                    .setLanguageCode("es")
                    .setSsmlGender(SsmlVoiceGender.FEMALE)
                    .build();

            AudioConfig audioConfig = AudioConfig.newBuilder()
                    .setAudioEncoding(AudioEncoding.MP3)
                    .setSpeakingRate(0.90)
                    .build();

            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
            ByteString audioContents = response.getAudioContent();
            return upload(audioContents, lesson.getId() + ".mp3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generateDefaultUrl(Lesson lesson) {
        return "https://storage.googleapis.com/fastesttyper/" + lesson.getId() + ".mp3";    }

    private String upload(ByteString outputStream, String name) {
        try {
            storage.create(
                    BlobInfo.newBuilder("fastesttyper", name).build(),
                    outputStream.toByteArray(),
                    Storage.BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ)
            );
            return "https://storage.googleapis.com/fastesttyper/" + name;
        }catch(IllegalStateException e){
            throw new RuntimeException(e);
        }
    }
}
