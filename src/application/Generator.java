package application;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Generator {

    public static String gerarSenha(int comprimento, boolean incluirLetrasMin, boolean incluirNumeros,
            boolean incluirEspeciais) {
        StringBuilder senha = new StringBuilder();
        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Caracteres maiúsculos são incluídos por padrão

        if (incluirLetrasMin) {
            caracteresPermitidos += "abcdefghijklmnopqrstuvwxyz";
        }
        if (incluirNumeros) {
            caracteresPermitidos += "0123456789";
        }
        if (incluirEspeciais) {
            caracteresPermitidos += "!@#$%^&*()_+";
        }

        Random random = new SecureRandom();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            senha.append(caracteresPermitidos.charAt(index));
        }

        return senha.toString();
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Informe o comprimento da senha: ");
            int length = sc.nextInt();
            sc.nextLine(); // Limpa o buffer de entrada

            System.out.println("Incluir letras minúsculas? (S/N): ");
            boolean incluirLetrasMin = sc.nextLine().equalsIgnoreCase("S");

            System.out.println("Incluir números? (S/N): ");
            boolean incluirNumeros = sc.nextLine().equalsIgnoreCase("S");

            System.out.println("Incluir caracteres especiais? (S/N): ");
            boolean incluirEspeciais = sc.nextLine().equalsIgnoreCase("S");

            String senhaGerada = gerarSenha(length, incluirLetrasMin, incluirNumeros, incluirEspeciais);
            System.out.println("Senha gerada: " + senhaGerada);

            sc.close();

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número válido.");
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao ler entrada do usuário.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Índice de string inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido.");
        } catch (NullPointerException e) {
            System.out.println("Erro de objeto nulo.");
        }

    }
}