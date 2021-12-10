import javax.swing.JOptionPane;

public class CalculadoraSalario {

    public static void main(String[] args) {

        /*Projeto - programa que calcula folha de pagamento*/

        float INSS = 0;
        int escalaDeTabalho;
        float VT = 6;
        float descontos = 0;
        float VR = 20;
        float valeAlimentação = 0;


        float salarioBruto = Float.parseFloat(JOptionPane.showInputDialog("Infome o seu salário Bruto: "));

        if(salarioBruto <= 1830.29){
            INSS = 8;
        } else if(salarioBruto >= 1830.29 || salarioBruto <= 3050.52){
            INSS = 9;
        } else if(salarioBruto >= 3050.53){
            INSS = 11;
        }

        escalaDeTabalho = Integer.parseInt(JOptionPane.showInputDialog("Digite 0 (Zero) se trabalha de Seg a Sex " +
                "ou 1 se trabalha de Seg a Sab: "));

        switch (escalaDeTabalho){
            case 0:
                escalaDeTabalho = 21;
                break;
            case 1:
                escalaDeTabalho = 26;
                break;

        }

        String validacaoVR = JOptionPane.showInputDialog("Utiliza Recebe Vale-Alimentação? Digite S se utiliza," +
                " e N se não utiliza e X caso receba e não seja descontado: ");

        switch (validacaoVR){
            case "S":
                VR = 20;
                valeAlimentação = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor diário" +
                        " do seu vale alimentação:  "));
                break;
            case "N":
                VR = 0;
                break;
            case "X":
                VR = 0;
                break;
            default:
                VR = 20;
                break;
        }


        valeAlimentação = (valeAlimentação * VT) /100;

        String validacaoVT = JOptionPane.showInputDialog("Utiliza Vale-Transporte? Digite S se utiliza" +
                " e N se não utiliza");

        switch (validacaoVT){
            case "sim":
                VT = 6;
                break;
            case "nao":
                VT = 0;
                break;
            default:
                VT = 6;
                break;
        }

        VT = (salarioBruto * VT) / 100;
        descontos = ((salarioBruto * INSS) /100) + valeAlimentação + VT;

        float salarioLiquido = salarioBruto - descontos;

        JOptionPane.showMessageDialog(null, "Total Liquido: " + salarioLiquido);

    }
}
