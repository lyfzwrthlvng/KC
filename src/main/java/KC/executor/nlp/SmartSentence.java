package KC.executor.nlp;

import KC.entities.KCAccessRequest;
import KC.entities.KCWriteRequest;
import KC.entities.NodeResult;
import KC.executor.Node;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class SmartSentence implements Node {

    SentenceModel sentenceModel;
    SentenceDetectorME sentenceDetector;

    public SmartSentence(){
        try {
            this.sentenceModel = new SentenceModel(new FileInputStream("src/resources/models/en-sent.bin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sentenceDetector = new SentenceDetectorME(sentenceModel);
    }

    @Override
    public boolean process(KCAccessRequest request) {
        KCWriteRequest writeRequest = (KCWriteRequest) request;
        NodeResult result = new NodeResult();
        String[] sentences = sentenceDetector.sentDetect(writeRequest.getValue());



        result.setResult(new HashMap<>());
        result.getResult().put("sentences", sentences);
        setOutput(result);
        return true;
    }

    @Override
    public boolean process() {
        return false;
    }

    @Override
    public NodeResult getOutput() {
        return null;
    }

    @Override
    public void setOutput(NodeResult result) {
        output.setResult(result.getResult());
    }

    @Override
    public String getResultNameForNode() {
        // Doesn't really need a result
        return "Sentences";
    }
}
