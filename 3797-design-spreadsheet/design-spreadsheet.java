class Spreadsheet {
    private int[][] sheets;

    public Spreadsheet(int rows) {
        sheets = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheets[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheets[row][col] = 0;
    }

    private int solve(String s){
        if(Character.isDigit(s.charAt(0))) return Integer.parseInt(s);

        int col = s.charAt(0) - 'A';
        int row = Integer.parseInt(s.substring(1)) - 1;
        return sheets[row][col];
    }
    
    public int getValue(String formula) {
        String s = formula.substring(1); //remove '='
        int plusIdx = s.indexOf('+');

        String left = s.substring(0 , plusIdx);
        String right = s.substring(plusIdx + 1);

        return solve(left) + solve(right);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */