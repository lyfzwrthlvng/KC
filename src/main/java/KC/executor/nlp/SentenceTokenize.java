package KC.executor.nlp;

import KC.entities.KCAccessRequest;
import KC.entities.KCWriteRequest;
import KC.entities.NodeResult;
import KC.executor.Node;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class SentenceTokenize implements Node {

    TokenizerModel tokenizerModel;
    TokenizerME tokenizer;

    public SentenceTokenize() {
        try {
            this.tokenizerModel = new TokenizerModel(new FileInputStream("src/resources/models/en-token.bin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.tokenizer = new TokenizerME(tokenizerModel);
    }

    @Override
    public boolean process(KCAccessRequest request) {
        KCWriteRequest writeRequest = (KCWriteRequest) request;
        String[] tokens = tokenizer.tokenize(writeRequest.getValue());
        NodeResult result = new NodeResult();
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put(getResultNameForNode(), tokens);
        result.setResult(resultMap);
        setOutput(result);
        return true;
    }

    @Override
    public boolean process() {
        return false;
    }

    @Override
    public NodeResult getOutput() {
        return output;
    }

    @Override
    public void setOutput(NodeResult result) {
        output.setResult(result.getResult());
    }

    @Override
    public String getResultNameForNode() {
        return "Tokens";
    }
}
