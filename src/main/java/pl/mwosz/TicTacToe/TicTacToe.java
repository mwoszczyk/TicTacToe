package pl.mwosz.TicTacToe;

public class TicTacToe {

    private int[][] tab;
    private int n;
    private int round = 0;
    private viewUpdate view;
    private winCheck winInterface;

    public TicTacToe() {
        this.tab = new int[3][3];
        this.n = tab.length;
    }

    public int getN() {
        return n;
    }

    public void setWinInterface(winCheck win) {
        this.winInterface = win;
    }

    public void setView(viewUpdate viewUpdate) {
        this.view = viewUpdate;
    }

    public int checkWin() {
        boolean flag = true;
        if (tab[0][0] != 0 && (tab[0][0] == tab[0][1] && tab[0][1] == tab[0][2]) && flag) {
            flag = false;
        } else if (tab[1][0] != 0 && (tab[1][0] == tab[1][1] && tab[1][1] == tab[1][2]) && flag) {
            flag = false;
        } else if (tab[2][0] != 0 && (tab[2][0] == tab[2][1] && tab[2][1] == tab[2][2]) && flag) {
            flag = false;
        } else if (tab[0][0] != 0 && (tab[0][0] == tab[1][0] && tab[1][0] == tab[2][0])  && flag) {
            flag = false;
        } else if (tab[0][1] != 0 && (tab[0][1] == tab[1][1] && tab[1][1] == tab[2][1])  && flag) {
            flag = false;
        } else if (tab[0][2] != 0 && (tab[0][2] == tab[1][2] && tab[1][2] == tab[2][2])  && flag) {
            flag = false;
        } else if (tab[0][0] != 0 && (tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2])  && flag) {
            flag = false;
        } else if (tab[2][0] != 0 && (tab[2][0] == tab[1][1] && tab[1][1] == tab[0][2])  && flag) {
            flag = false;
        }
        if (flag) {
            return 0;
        } else {
            return 1;
        }
    }

    public void move(int i, int j) {
        if (tab[i][j] > 0 || checkWin() == 1) {
            return;
        }

        if (round % 2 == 0) {
            System.out.println("Circle picking:");
            tab[i][j] = 1;
            view.checkUpdate(i,j, "X");
            if (checkWin() == 1) {
                winInterface.isItWin(i, j,"win");
            }
        } else {
            System.out.println("Cross picking:");
            tab[i][j] = 2;
            view.checkUpdate(i, j, "O");
            if (checkWin() == 1) {
                winInterface.isItWin(i,j, "win");
            }
        }
        round++;
    }
}
