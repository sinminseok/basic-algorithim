package graph;

public class graphArray {
    private int[][] array;

    public graphArray(int size) {
        array = new int[size+1][size+1];
    }

    //array를 가져오는 함수
    public int[][] getArray(){
        return array;
    }

    //array가 비어 있는지 확인하는 함수
    public boolean isEmpty(){
        return array == null;
    }

    //정점 x와 정점y 를 단방향으로 연결해주는 함수
    public void addDirectedEdge(int  x, int y){
        array[x][y] = 1;
    }

    //정점 x와 정점 y를 양방향으로 연결해주는 함수
    public void addCompleteEdge(int x, int y){
        array[x][y] = 1;
        array[y][x] = 1;
    }


    public void deleteDirectedEdge(int x, int y){
        array[x][y] = 0;
    }

    public void deleteCompleteEdge(int x, int y){
        array[x][y] = 0;
        array[y][x] = 0;
    }

    public void printArray(){
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
