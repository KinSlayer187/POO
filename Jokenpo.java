import java.util.Random;
import java.util.Scanner;

public class Jokenpo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        
        System.out.println("===== JOKENPÔ =====");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
        System.out.print("Sua escolha: ");

        int escolhaUsuario = validarEntrada(scanner);
        int escolhaComputador = random.nextInt(3) + 1; 

        System.out.println("\nVocê escolheu: " + opcoes[escolhaUsuario - 1]);
        System.out.println("O computador escolheu: " + opcoes[escolhaComputador - 1]);

        determinarVencedor(escolhaUsuario, escolhaComputador);
        
        scanner.close();
    }

    private static int validarEntrada(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida! Escolha 1 (Pedra), 2 (Papel) ou 3 (Tesoura): ");
            scanner.next();
        }
        int escolha = scanner.nextInt();
        while (escolha < 1 || escolha > 3) {
            System.out.print("Número inválido! Escolha 1 (Pedra), 2 (Papel) ou 3 (Tesoura): ");
            escolha = scanner.nextInt();
        }
        return escolha;
    }

    private static void determinarVencedor(int usuario, int computador) {
        if (usuario == computador) {
            System.out.println("🟡 EMPATE!");
        } else if ((usuario == 1 && computador == 3) || 
                   (usuario == 2 && computador == 1) || 
                   (usuario == 3 && computador == 2)) {
            System.out.println("✅ VOCÊ VENCEU!");
        } else {
            System.out.println("❌ O COMPUTADOR VENCEU!");
        }
    }
}
