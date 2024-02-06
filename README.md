# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS: Muneeb Zaman

## PART C
        - Changed name of shop's HTML on line 14 and 19.
        - Added parts related to the company's coffee machine from line 96-100.
        - Added products that the shop offers from line 104-108.
## PART D
        - Added an About Us page for the company.
        - About Us page is named about.html, located in src/main/resources/templates.
        - Controller was also created with @GetMapping, so that when a link to about.html is clicked, the page will be returned. Controller was named WebController.java, and is located at src/main/java/com.example.demo/controllers.
        - Linked the About Us page and mainscreen pages to and from each other.
## PART E
        - Added five outsourced parts and five products to the sample inventory in a new java class, DatabaseLoader.java. The file is located in src/main/java/com.example.demo. Used similar template that was provided in src/main/java/com.example.demo/bootstrap/BootStrapData.java.
        - Imported the part and product repositories to DatabaseLoader.java file starting from line 5-9.
        - Used CommandLineRunner to save parts and products to repository on line 15.
        - Saved the outsourced parts to the OutsourcedPart repository on line 93.
        - On each product (from line 97-110), products were saved to ProductRepository.
## PART F
        - Added a Buy Now button to the products list on line 86-89 of mainscreen.html. 
        - Created a new file in com.example.demo/controllers, called ProductPurchaseController.java. Created two new html pages in resources/templates, called purchaseError.html and purchaseSuccess.html.
        - In ProductPurchaseController.java, based on productId (on line 18-19), either purchaaseError.html will be returned or purchaseSuccess.html will return if productId is correct. The inventory will also be subtracted by 1 (on line 30-31) if productId is found.  
## PART G
        - Added minimum and maximum inventory to parts list in OutsourcedPartForm.html and InhousePartForm.html after price label.
        - In Part.java, added setters and getters for minInv and maxInv so that the user can set the min and maxInv of the part (line 93 and 96).
        - Added a constructor (line 62-69) for a part that has a minInv and maxInv.
        - Added @Min annotation (line 34-38) so that minimum and maximum inventory cannot be below zero.
## PART H
        - Added an if statement (line 119-130) so that if user tries to set the inventory to below the minimum or above the maximum, an error will show.
## PART I
        - Added two tests to partTest.java: setMinInv() and setMaxInv() (line 160-176). Using partIn and partOut to test if setMinInv() and setMaxInv() correctly set the inventory values in Part.java.
## PART J
        - Removed one validator DeletePartValidator.java. This had 0 usages according to IntelliJ, so it was removed.