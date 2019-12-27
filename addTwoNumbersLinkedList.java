import java.math.BigDecimal;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Test {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		StringBuilder listToDigit1 = new StringBuilder();
		StringBuilder listToDigit2 = new StringBuilder();

		BigDecimal sum = new BigDecimal(0);

		ListNode currentListNode = l1;

		if (currentListNode.next == null) {
			listToDigit1.append(currentListNode.val);
		} else {
			while (currentListNode.next != null) {
				listToDigit1.append(currentListNode.val);
				currentListNode = currentListNode.next;
			}
			listToDigit1.append(currentListNode.val);
		}

		currentListNode = l2;

		if (currentListNode.next == null) {
			listToDigit2.append(currentListNode.val);
		} else {
			while (currentListNode.next != null) {
				listToDigit2.append(currentListNode.val);
				currentListNode = currentListNode.next;
			}
			listToDigit2.append(currentListNode.val);
		}

		sum = new BigDecimal(listToDigit1.reverse().toString()).add(new BigDecimal(listToDigit2.reverse().toString()));

		char[] charArray = sum.toString().toCharArray();

		currentListNode = new ListNode(Character.getNumericValue(charArray[charArray.length - 1]));

		ListNode outNode = currentListNode;

		if (charArray.length > 1) {
			for (int i = charArray.length - 2; i >= 0; i--) {
				currentListNode.next = new ListNode(Character.getNumericValue(charArray[i]));
				currentListNode = currentListNode.next;
			}
		}

		return outNode;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(2);
		l.next = new ListNode(4);
		l.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		Test.addTwoNumbers(l, l2);
	}

}
