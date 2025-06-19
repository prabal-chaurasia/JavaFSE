class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return "[" + taskId + ", " + taskName + ", " + status + "]";
    }
}

public class TaskManagementSystem {
    Task head;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public Task searchTask(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            head = head.next;
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(1, "Design Database", "Pending");
        tms.addTask(2, "Develop API", "In Progress");
        tms.addTask(3, "Write Documentation", "Completed");

        System.out.println("All Tasks:");
        tms.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task task = tms.searchTask(2);
        System.out.println(task);

        System.out.println("\nDeleting Task with ID 1:");
        tms.deleteTask(1);

        System.out.println("\nTasks after Deletion:");
        tms.traverseTasks();
    }
}
