package KC.executor.nlp;

import KC.entities.KCAccessRequest;
import KC.entities.KCWriteRequest;
import KC.entities.NodeResult;
import KC.executor.Node;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartsOfSpeechTagger implements Node {

    POSModel model;
    POSTaggerME tagger;

    public PartsOfSpeechTagger() {
        try {
            model = new POSModel(new FileInputStream("src/resources/models/en-pos-maxent.bin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        tagger = new POSTaggerME(model);
    }

    @Override
    public boolean process(KCAccessRequest request) {
        KCWriteRequest writeRequest = (KCWriteRequest)request;
        WhitespaceTokenizer tokenizer = WhitespaceTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(writeRequest.getValue());
        tagger.tag(tokens);
        List<String> tokensList = new ArrayList<String>();
        for(String token: tokens) {
            tokensList.add(token);
        }
        List<String> tagsList = new ArrayList<>();
        String[] tags = tagger.tag(tokens);
        for(String tag: tags) {
            tagsList.add(tag);
        }

        tagger.getOrderedTags(tokensList, tagsList, 0);
        //String tags[] = tagger.getAllPosTags();
        HashMap<String, String> pairs = new HashMap<>();
        for(int i=0; i<tokensList.size(); i++) {
            if(tagsList.get(i).equalsIgnoreCase("NN")) {
                pairs.put(tokensList.get(i), tagsList.get(i));
            }
        }
        NodeResult result = new NodeResult();
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put(getResultNameForNode(), pairs);
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
        return "Tags";
    }
}
