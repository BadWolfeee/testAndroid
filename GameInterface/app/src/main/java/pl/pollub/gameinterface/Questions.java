package pl.pollub.gameinterface;

public class Questions {

    public String mojePytania [] ={
        "Pytanie 1 ",
        "Pytanie 2 ",
        "Pytanie 3 ",
        "Pytanie 4 ",
        "Pytanie 5 "
    };

    public String mojeOdp [][]={
            {"1Odpowiedź1","1Odpowiedź2","1Odpowiedź3","1Odpowiedź4"},
            {"2Odpowiedź1","2Odpowiedź2","2Odpowiedź3","2Odpowiedź4"},
            {"3Odpowiedź1","3Odpowiedź2","3Odpowiedź3","3Odpowiedź4"},
            {"4Odpowiedź1","4Odpowiedź2","4Odpowiedź3","4Odpowiedź4"},
            {"5Odpowiedź1","5Odpowiedź2","5Odpowiedź3","5Odpowiedź4"},
    };

    private String prawidOdp []={
            "1Odpowiedź1","2Odpowiedź2","3Odpowiedź3","4Odpowiedź4","5Odpowiedź4"
    };

    public String getQuestion(int a){
        String quest = mojePytania[a];
        return quest;
    }

    public String getOpt1(int a){
        String odp = mojeOdp[a][0];
        return odp;
    }

    public String getOpt2(int a){
        String odp = mojeOdp[a][1];
        return odp;
    }

    public String getOpt3(int a){
        String odp = mojeOdp[a][2];
        return odp;
    }

    public String getOpt4(int a){
        String odp = mojeOdp[a][3];
        return odp;
    }

    public String getCorrAnsw(int a){
        String answ = prawidOdp[a];
        return answ;
    }
}
