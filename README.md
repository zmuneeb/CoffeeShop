# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS: Muneeb Zaman

## PART C
        - Changed name of shop's HTML.
        - Added parts related to the company's coffee machine
        - Added products that the shop offers
## PART D
        - Added an About Us page for the company
        - Linked the About Us page and mainscreen pages to and from each other
## PART E
        - Added five outsourced parts, and five products to the sample inventory
## PART F
        - Added a Buy Now button to the products list. It will decrease the inventory by 1
        - Added two new HTML pages, for a successful purchase or an unsuccessful purchase
## PART G
        - Added minimum and maximum inventory to parts list in OutsourcedPartForm.html and InhousePartForm.html
        - In Part.java, added setters and getters for minInv and maxInv so that the user can set the min and maxInv of the part
        - Added an if statement so that if user tries to set the inventory to below the minimum or above the maximum, an error will show
## PART H
        - Added more statements to catch errors if inventory is too low or if user updates a part or product above the max inventory
## PART I
        - Added two tests to partTest.java: setMinInv() and setMaxInv(). Using partIn and partOut to test the code for errors.
## PART J
        - Removed one validator DeletePartValidator.java. This had 0 usages according to IntelliJ, so it was removed.