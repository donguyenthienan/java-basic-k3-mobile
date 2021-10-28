package lesson09;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LAB9_1 {
    static String key = "raceCount";
    public static void main(String[] args) throws Exception {
        int MAXROUND = 10;
        Animal winner;
        for (int i = 1; i <= MAXROUND; i++) {
            Animal tiger1 = new Tiger();
            Animal tiger2 = new Tiger();
            Animal elephant1 = new Elephant();
            Animal elephant2 = new Elephant();
            Animal horse1 = new Horse();
            Animal horse2 = new Horse();
            List<Animal> racingList = Arrays.asList(tiger1, tiger2, elephant1, elephant2, horse1, horse2);
            winner = getWinner(racingList);
            logRacing(String.format("Winner in round %d is %s", i , winner.getClass().getSimpleName()));
        }
        summarize();
    }

    private static Animal getWinner(List<Animal> animalList) throws Exception {
        Animal winner = null;
        List<Animal> drawAnimalList = new ArrayList<>();
        for (Animal animal : animalList) {
            if(winner == null){
                winner = animal;
                continue;
            }
            if(animal.speed() == winner.speed()) drawAnimalList.add(animal);
            if(animal.speed() > winner.speed()) {
                drawAnimalList.clear();
                winner = animal;
            }
        }
        drawAnimalList.add(winner);
        //Re-racing
        if(drawAnimalList.size() > 1) return getWinner(drawAnimalList);

        switch (winner.getClass().getSimpleName()){
            case "Horse":
                Horse.countMap.put(key, Horse.countMap.get(key) + 1);
                break;
            case "Tiger":
                Tiger.countMap.put(key, Tiger.countMap.get(key) + 1);
                break;
            case "Elephant":
                Elephant.countMap.put(key, Elephant.countMap.get(key) + 1);
                break;
            default:
                throw new Exception("There is no " + winner.getClass().getSimpleName());
        }
        return winner;
    }
    static void summarize(){
        List<Map> mapList = Arrays.asList(Elephant.countMap, Tiger.countMap, Horse.countMap);
        Map max = Elephant.countMap;
        for (Map map : mapList) {
            max = (Integer) map.get(key) > (Integer) max.get(key) ? map : max;
        }
        String summary = "Winner is %s";
        if(max.getClass().getName().contains("Elephant")) logRacing(String.format(summary,"Elephant"));
        if(max.getClass().getName().contains("Tiger")) logRacing(String.format(summary,"Tiger"));
        if(max.getClass().getName().contains("Horse")) logRacing(String.format(summary,"Horse"));
    }
    static void logRacing(String text, String path){
        try(FileOutputStream fileOutputStream = new FileOutputStream(path,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ){
            bufferedWriter.append(text);
            bufferedWriter.newLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    static void logRacing(String text){
        logRacing(text, "src/lesson09/RacingResult.txt");
        System.out.println(text);
    }

}
