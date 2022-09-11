@findBeymen
Feature: feature to test find item functionality

  @findItem
  Scenario: Open Browser and Find Item
    Given OPEN BROWSER AND LOGIN
    When ON MAIN PAGE
    When  ENTER ITEM1
    When DELETE ITEM
    When  ENTER ITEM2
    Then CLICK ENTER
  @select
  Scenario: Select Item and Getting Information of Item to Add Basket
    When SELECT ITEM
    When GET INFO
    Then ADD BASKET
  @basket
  Scenario: Open Basket, Add One More Item and Delete All
    When OPEN BASKET
    When ADD ITEM
    Then DELETE ALL ITEM


