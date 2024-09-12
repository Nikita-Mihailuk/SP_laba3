import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int MAX_VOTES = 1000;
        final int PAIRS = 16;
        // ввод количества sms-сообщений
        int n = 0;
        System.out.println("Введите количество сообщений(ограничение 1000):");
        while (true){
            n = in.nextInt();
            if(n <= MAX_VOTES) break;
            else System.out.println("Неправильно введённое количество сообщений, введите ещё раз:");
        }

        // HashMap для хранения количества голосов за каждую пару, ключ - номер пары, значение - кол-во голосов
        HashMap<Integer, Integer> votes = new HashMap<>();

        // заполнение кол-ва голосов 0 для того чтобы выводились все пары, в том числе за которых нет голосов
        for (int i = 1; i <= PAIRS; i++) {
            votes.put(i,0);
        }

        // ввод номеров пар и подсчет голосов
        System.out.println("Введите номера пары за которую хотите проголосовать:");
        for (int i = 0; i < n; i++) {
            int pairNumber = in.nextInt();
            if (pairNumber <= 16) votes.put(pairNumber, votes.get(pairNumber) + 1);
        }

        // создание списка пар и их голосов для дальнейшей сортировки
        List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>(votes.entrySet());

        // сортировка пузырьком списка пар по количеству голосов в порядке убывания
        for (int i = 0; i < pairs.size() - 1; i++) {
            for (int j = 0; j < pairs.size() - i - 1; j++) {
                if (pairs.get(j).getValue() < pairs.get(j + 1).getValue()) {
                    Collections.swap(pairs, j, j + 1);
                }
            }
        }

        // вывод списка пар и их голосов
        System.out.println("Итоги голосования:");
        for (Map.Entry<Integer, Integer> pair : pairs) {
            System.out.println("Пара " + pair.getKey() + ": " + pair.getValue() + " голосов");
        }
    }
}
