package pl.pollub.gameinterface;

public class Questions {

    public String mojePytania [] ={
        "Gdzie znajduje się wieża wodna? ",
        "Który król nadał Lublinowi prawa miejskie? ",
        "Regionalny przysmak Lublina to :  ",
        "Pojazdy miejskie, które poruszają się jedynie po trzech miastach w Polsce. Jeździmy nimi w Lublinie",
        "Baobab to: "
    };

    public String mojeOdp [][]={
            {"ul. Rusałka","ul. Graniczna","ul. Dolna Panny Marii","ul. Wesoła"},
            {"Władysław Łokietek","Kazimierz Wielki","Zygmunt August","Jan III Sobieski"},
            {"Rogalik świętomarciński","Cebularz","Kogucik ","Gniazdko"},
            {"Trwamwaje","Trolejbusy","Metro","Autobus"},
            {"Jesion","Wierzba","Topola czarna","Dąb"},
    };

    private String prawidOdp []={
            "ul. Dolna Panny Marii","Władysław Łokietek","Cebularz","Trolejbusy","Topola czarna"
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
