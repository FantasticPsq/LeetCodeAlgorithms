import java.util.Arrays;
import java.util.List;

public class CanVisitAllRooms {

    static int count;
    boolean[] set;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        set = new boolean[rooms.size()];
        count = 0;
        dfs(0, rooms);
        return count == rooms.size();
    }

    public void dfs(int node, List<List<Integer>> rooms) {
        count++;
        set[node] = true;
        for (int i : rooms.get(node)) {
            if (!set[i]) {
                dfs(i, rooms);
            }
        }
    }
}
