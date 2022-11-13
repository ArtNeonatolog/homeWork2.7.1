import java.util.*;

public class Main {

    private static final List<String> NAMES = List.of(
            "Иван", "Артем", "Петр", "Аркадий", "Ильнур", "Денис", "Вова", "Миша", "Кирилл", "Роман"
    );

    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;

    public static void fillQueue(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }

    }

    private static void addHuman(String name, Queue<String> queue1, Queue<String> queue2, Queue<String> queue3) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE && queue3.size() == MAX_SIZE) {
            System.out.println("Позовите Галю");
            return;
        }
        if (queue1.size() < queue2.size() && queue1.size() < queue3.size()) {
            queue1.offer(name);
        } else if (queue2.size() < queue1.size() && queue1.size() < queue3.size()) {
            queue2.offer(name);
        } else {
            queue3.offer(name);
        }
    }

    private static void remove(Queue<String> queue1, Queue<String> queue2, Queue<String> queue3) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        }else{
            queue2.poll();
        queue3.poll();
    }
}

    public static void main(String[] args) {
        System.out.println("Задание 2");
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        Queue<String> queue3 = new ArrayDeque<>();
        fillQueue(queue1);
        fillQueue(queue2);
        fillQueue(queue3);
        System.out.println("Первая очередь - " + queue1 + ", 2 очередь - " + queue2 + ", 3 очередь - " + queue3);
        System.out.println();

        addHuman("Николай", queue1, queue2, queue3);
        System.out.println("Первая очередь - " + queue1 + ", 2 очередь - " + queue2 + ", 3 очередь - " + queue3);
        System.out.println();

        remove(queue1, queue2, queue3);
        System.out.println("Первая очередь - " + queue1 + ", 2 очередь - " + queue2 + ", 3 очередь - " + queue3);


    }

}
