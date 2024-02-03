//package com.app.FO.model.expenses;
//
//import com.app.FO.model.shop.Shop;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "expenses_shop")
//public class ExpensesShop {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_shop_seq")
//    @SequenceGenerator(name = "expenses_shop_seq",
//            sequenceName = "expenses_shop_seq",
//            initialValue = 1,
//            allocationSize = 1)
//    @Column(name = "expenses_shop_id")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "expenses_id")
//    @JsonIgnore
//    private Expenses expenses;
//
//    @ManyToOne
//    @JoinColumn(name = "shop_id")
//    @JsonIgnore
//    private Shop shop;
//
//    @Column(name = "expenses_date")
//    private LocalDateTime expensesDate;
//
//    public ExpensesShop() {
//    }
//
//    public ExpensesShop(Expenses expenses, Shop shop) {
//        this.expenses = expenses;
//        this.shop = shop;
//        this.expensesDate = LocalDateTime.now();
//    }
//
//    @Override
//    public String toString() {
//        return "ExpensesShop{" +
//                "id=" + id +
//                ", expensesId=" + expenses.getId() +
//                ", shopId=" + shop.getId() +
//                ", expensesDate=" + expensesDate +
//                '}';
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Expenses getExpenses() {
//        return expenses;
//    }
//
//    public void setExpenses(Expenses expenses) {
//        this.expenses = expenses;
//    }
//
//    public Shop getShop() {
//        return shop;
//    }
//
//    public void setShop(Shop shop) {
//        this.shop = shop;
//    }
//
//    public LocalDateTime getExpensesDate() {
//        return expensesDate;
//    }
//
//    public void setExpensesDate(LocalDateTime expensesDate) {
//        this.expensesDate = expensesDate;
//    }
//}
