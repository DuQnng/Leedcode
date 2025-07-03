public class wordExist {
    //习近平
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        if(i<0||i>=board.length||j<0||j>=board[0].length)
        {
            return false;
        }
        if(board[i][j]!=words[index])
        {
            return false;
        }
        if(index==words.length-1)
        {
            return true;
        }
        char originalCHar=board[i][j];
        board[i][j]='\0';
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:directions)
        {
            int newRow=i+dir[0];
            int newCol=j+dir[1];
            if(dfs(board,words,newRow,newCol,index+1))
            {
                board[i][j]=originalCHar;
                return true;
            }
        }
        board[i][j]=originalCHar;
        return false;
    }

}
