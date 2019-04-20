package GolovachDecember2013.CoreProcedural2.Sortings;

public class QuickSorts {
    private static void quickSort1(int[] dataArr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (dataArr[i] <= dataArr[cur])) {
                i++;
            }
            while (j > cur && (dataArr[cur] <= dataArr[j])) {
                j--;
            }
            if (i < j) {
                int temp = dataArr[i];
                dataArr[i] = dataArr[j];
                dataArr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickSort1(dataArr, start, cur);
        quickSort1(dataArr, cur + 1, end);
    }
}
