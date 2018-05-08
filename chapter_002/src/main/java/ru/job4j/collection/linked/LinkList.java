package popova.collection.linked;

import java.util.LinkedList;

public class LinkList {
    private LinkedList<Task> linkList = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if(linkList.size() != 0 ) {
            for (Task note : linkList) {
                if (note.getPriority() < task.getPriority()) {
                    break;
                } else {
                    index++;
                }
            }
        }
        linkList.add(index, task);
    }

    public Task take() {
        return this.linkList.poll();
    }

}
