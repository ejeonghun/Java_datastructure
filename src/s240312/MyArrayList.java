package s240312;

class MyArrayList {
    private int size = 0; // 순차리스트에 포함된 데이터 수 저장
    private Object[] elementData = new Object[100]; // 내부 자료구조로 배열 사용
    public MyArrayList() { }

    public boolean add(Object element) { // 순차리스트에 데이터 추가
        elementData[size] = element;
        size++;
        return true;
    }
    public boolean add(int index, Object element) { // 순차리스트에 데이터 삽입
        for (int i = size - 1; i >= index; i--) { 
            elementData[i + 1] = elementData[i]; // 해당 인덱스의 자리를 비우는 개념
        }
        elementData[index] = element;
        size++;
        return true;
    }

    public String toString() { // 순차리스트를 문자열로 변환
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementData[i];
            if (i < size - 1)
                str += ",";
        }
        return str + "]";
    }

    public Object remove(int index) { // 순차리스트에서 데이터 삭제
        Object removed = elementData[index];
        for (int i = index + 1; i <= size - 1; i++) { // i = 3; i<=4; i++
            elementData[i - 1] = elementData[i]; // 인덱스 2에 인덱스 3 값 대입 , 인덱스 3에 인덱스 4값 대입
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    public Object get(int index) { // 순차리스트 데이터 임의접근(읽기)
        return elementData[index];
    }
    public int size() { // 순차리스트
        return size;
    }
    public int indexOf(Object o) { // 순차리스트에서 데이터 검색
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }
}
class MyArrayListTest {
    public static void main(String[] args){
        MyArrayList numbers = new MyArrayList(); // 순차리스트 객체 생성
        numbers.add(10); // 데이터 추가
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        System.out.println("순차리스트(MyArrayList)");
        System.out.println(numbers);
        numbers.add(1, 50); // 데이터 삽입
        System.out.println("\nadd(1, 50)");
        System.out.println(numbers);
        numbers.remove(2); // 데이터 삭제
        System.out.println("\nremove(2)");
        System.out.println(numbers);
        System.out.println("\nget(2)");
        System.out.println(numbers.get(2)); // 데이터 접근
        System.out.println("\nsize()");
        System.out.println(numbers.size()); // 데이터 수
        System.out.println("\nindexOf(30)");
        System.out.println(numbers.indexOf(30)); // 데이터 검색
        System.out.println("\nfor문");
        for (int i = 0; i < numbers.size(); i++) { // 순차리스트 순회
            System.out.print(numbers.get(i) + " ");
        }
    }
}
