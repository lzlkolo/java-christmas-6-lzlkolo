package christmas.ui;

import java.util.Map;

public class OutputView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayOrder(Map<String, Integer> orderItems) {
        System.out.println("<주문 메뉴>");

        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }

        System.out.println();
    }

    public void displayTotalOrderPrice(int totalDiscount) {
        System.out.println("<할인 전 총주문 금액>");

        String priceFormat = formatPrice(totalDiscount);
        System.out.println(priceFormat + "원");

        System.out.println();
    }

    public void displayGiftEvent(boolean hasGiftEvent) {
        System.out.println("<증정 메뉴>");

        if (hasGiftEvent) {
            System.out.println("샴페인 1개");
        }

        if (!hasGiftEvent) {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void displayEventPreview(Map<String, Integer> events) {
        System.out.println("<혜택 내역>");

        if (events.isEmpty()) {
            System.out.println("없음");
        }

        for (Map.Entry<String, Integer> entry : events.entrySet()) {
            String priceFormat = formatPrice(entry.getValue());
            System.out.println(entry.getKey() + ": -" + priceFormat + "원");
        }

        System.out.println();
    }

    public void displayTotalDiscount(int totalDiscount) {
        System.out.println("<총혜택 금액>");

        if (totalDiscount == 0) {
            System.out.println("0원");
        }

        if (totalDiscount != 0) {
            String priceFormat = formatPrice(totalDiscount);
            System.out.println("-" + priceFormat + "원");
        }

        System.out.println();
    }

    public void displayPaymentPrice(int paymentPrice) {
        System.out.println("<할인 후 예상 결제 금액>");

        String priceFormat = formatPrice(paymentPrice);
        System.out.println(priceFormat + "원");

        System.out.println();
    }

    public void displayBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    private String formatPrice(int price) {
        String priceFormat = String.format("%,d", price);
        return priceFormat;
    }
}
