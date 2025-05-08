package io.reflectoring.sparky.usuarioFinal.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.ai.inference.ChatCompletionsClient;
import com.azure.ai.inference.ChatCompletionsClientBuilder;
import com.azure.ai.inference.models.ChatCompletions;
import com.azure.ai.inference.models.ChatCompletionsOptions;
import com.azure.ai.inference.models.ChatRequestMessage;
import com.azure.ai.inference.models.ChatRequestSystemMessage;
import com.azure.ai.inference.models.ChatRequestUserMessage;
import com.azure.core.credential.AzureKeyCredential;

import io.reflectoring.sparky.modeloIA.domain.ModeloIA;
import io.reflectoring.sparky.modeloIA.infrastructure.ModeloIARepository;
import io.reflectoring.sparky.solicitud.domain.Solicitud;
import io.reflectoring.sparky.usuarioFinal.infrastructure.UsuarioFinalRepository;

@Service
public class UsuarioFinalService {
    private final ChatCompletionsClient client;
    private final ModeloIARepository modeloIARepository;
    private final UsuarioFinalRepository usuarioFinalRepository;

    @Value("${azure.key}")
    private String key;

    public UsuarioFinalService(UsuarioFinalRepository usuarioFinalRepository, ModeloIARepository modeloIARepository) {
        this.usuarioFinalRepository = usuarioFinalRepository;
        this.modeloIARepository = modeloIARepository;
        String endpoint = "https://models.github.ai/inference";

        this.client = new ChatCompletionsClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();
    }

    public String chat(String userPrompt) {
        List<ChatRequestMessage> messages = Arrays.asList(
                new ChatRequestSystemMessage("You are a helpful assistant."),
                new ChatRequestUserMessage(userPrompt));

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages);
        String model = "openai/gpt-4.1-nano";
        options.setModel(model);

        ChatCompletions completions = client.complete(options);
        if (completions.getChoices() != null && !completions.getChoices().isEmpty()) {
            return completions.getChoices().get(0).getMessage().getContent();
        } else {
            return "No se recibieron respuestas del modelo.";
        }
    }

    public String completacion(String userPrompt) {
        List<ChatRequestMessage> messages = Arrays.asList(
                new ChatRequestSystemMessage("You are a helpful assistant."),
                new ChatRequestUserMessage(userPrompt));

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages);
        String model = "openai/text-davinci-003";
        options.setModel(model);

        ChatCompletions completions = client.complete(options);
        if (completions.getChoices() != null && !completions.getChoices().isEmpty()) {
            return completions.getChoices().get(0).getMessage().getContent();
        } else {
            return "No se recibieron respuestas del modelo.";
        }
    }

    public String multimodal(String userPrompt) {
        List<ChatRequestMessage> messages = Arrays.asList(
                new ChatRequestSystemMessage("You are a helpful assistant."),
                new ChatRequestUserMessage(userPrompt));

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages);
        String model = "openai/gpt-4.1-nano";
        options.setModel(model);

        ChatCompletions completions = client.complete(options);
        if (completions.getChoices() != null && !completions.getChoices().isEmpty()) {
            return completions.getChoices().get(0).getMessage().getContent();
        } else {
            return "No se recibieron respuestas del modelo.";
        }
    }

    public List<ModeloIA> obtenerModelos() {
        return modeloIARepository.findAll();
    }

    public List<Solicitud> obtenerHistorial() {
        return usuarioFinalRepository.;
    }
}
