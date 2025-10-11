class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> pq=new PriorityQueue<>(Comparator.comparing(Task::freq).reversed()); // max heap
        Map<Character,Integer> freqMap=new HashMap<>();
        for(char task:tasks) freqMap.put(task,freqMap.getOrDefault(task,0)+1);
        for(char task:freqMap.keySet()) pq.add(new Task(task,freqMap.get(task)));

        Queue<WaitingTask> waitQueue = new ArrayDeque<>();
        int time=0; // current time
        while(!pq.isEmpty() || !waitQueue.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                Task task=pq.poll(); // greedy approach: we'll use the task with most occurences left
                task.freq--;
                if(task.freq!=0) waitQueue.add(new WaitingTask(task,time+n)); // the task will be available again after the cooldown period
            }

            if(!waitQueue.isEmpty()) { // check wait queue to see if any waiting task is ready to be added to the max heap
                WaitingTask waitingTask=waitQueue.peek();
                if(waitingTask.nextAvailable==time) pq.add(waitQueue.poll().task);
            }
        }
        return time;
    }
}

class Task {
    char ch;
    int freq;

    Task(char ch, int freq) {
        this.ch=ch;
        this.freq=freq;
    }

    int freq() { return this.freq; }
}

class WaitingTask {
    Task task;
    int nextAvailable;

    WaitingTask(Task task, int nextAvailable) {
        this.task=task;
        this.nextAvailable=nextAvailable;
    }
}