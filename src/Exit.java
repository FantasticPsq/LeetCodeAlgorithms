import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class Exit {
    public int flag = 0;
    public boolean exist(char[][] board, String word) {
        boolean[][] selected = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    dfs(i,j,board,word,selected,0);
                }
            }
        }
        return flag==1;
    }
    public void dfs(int x_index,int y_index,char[][] board,String word,boolean[][] selected,int k){
        if(x_index>=board.length||y_index>=board[0].length||x_index<0||y_index<0){
            return;
        }
        if(selected[x_index][y_index]){
            return;
        }
        selected[x_index][y_index] = true;
        if(word.charAt(k)==board[x_index][y_index]){
            k++;
            if(k==word.length()){
                flag = 1;
            }
            if(flag!=1){
                dfs(x_index+1,y_index,board,word,selected,k);
                dfs(x_index,y_index-1,board,word,selected,k);
                dfs(x_index-1,y_index,board,word,selected,k);
                dfs(x_index,y_index+1,board,word,selected,k);
            }
        }
        selected[x_index][y_index] = false;
    }
}
