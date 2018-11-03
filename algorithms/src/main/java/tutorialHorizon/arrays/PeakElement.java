package tutorialHorizon.arrays;

/**
 * Created by archith.rapaka on 6/22/17.
 * peak element is the element which is greater than or equal to both of its neighbors.
 */
public class PeakElement {


    public static int findPeakElement(int[] a, int low, int high) {

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (a[mid] >= a[mid - 1] && a[mid] >= a[mid + 1]) {
                return mid;
            } else if (a[mid] < a[mid - 1]) {
                return findPeakElement(a, low, mid - 1);
            } else {

                return findPeakElement(a, mid + 1, high);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//		List<User> list = new ArrayList<>();
//		Collections.sort(list, Comparator.comparing(User::getUsername));
//		list.sort((user1,user2) -> user1.getProfession().compareTo(user2.getProfession()));
//		Comparator userComparator = Comparator.comparing(User::getProfession,Comparator.reverseOrder());
//
//		list.sort(userComparator.reversed());
//		//Multiple properties
//		Comparator multipleProps = Comparator.comparingInt(User::getAge)
//				                   .thenComparing(User::getUsername , Comparator.nullsLast(naturalOrder()));
//		String foo = "Hello";
//		foo = foo.substring(0,3);
//		System.out.println(foo);
//		List<User> umn = Collections.unmodifiableList(list);
//		List<Integer> ints = Collections.EMPTY_LIST;
//		//int[] a = new int[-2];
//
//		String s = "A";
//		switch (s) {
//			case "a" : System.out.println(s);
//			default:System.out.println("default");
//			case "A" : System.out.print("he");
//		}
        int a[] = {1, 2, 3, 4, 0, 1, 5, 4, 3, 2, 1};
        int indexPeak = findPeakElement(a, 0, a.length - 1);
        System.out.print(indexPeak == -1 ? -1 : a[indexPeak]);

    }

}
