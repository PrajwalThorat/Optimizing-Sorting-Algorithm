## Problem Statement - Optimizing Sorting Algorithm

In this challenge, you are going to revisit the solution created for challenge-32 and will check the time taken to perform the sorting operations on the given dataset using `System.currentTimeMillis()`. It was one of the client requirement to ensure that the sorting algorithm will have to take minimal time. 

> Please note that this data set is publicly available and is downloaded from `https://www.kaggle.com/PromptCloudHQ/flipkart-products`.

The file contains the following information:
- pid - contains the unique product ID
- product_name - contains the product name as it is displayed on the site
- brand - contains the brand of the product being sold.
- product_url - contains the URL for the product.
- retail_price - contains the retail price excluding any discount
- discounted_price - contains the discounted price excluding any discount
- product_rating - contains the product_ratings. product_rating can be ranging from 1 to 5. However, there are several products which does not have any rating. In those cases, the ratings should be considered as 0.

Following are the key objectives for this challenge:

- Note down the time taken to sort the list using the existing methods.
- Optimize the method to sort the list of products based on it's price, which is already written as a part of the previous challenge. Please note that the sorting can be done in either ascending or descending order.
- Optimize the method to sort the list of products based on it's ratings in descending order only, which is already written as a part of the previous challenge.
- Note down the time taken to sort the list using the refactored methods which uses the optimized algorithm.
- Find out the effective improvement in execution time(in ms).

> You need handle all exceptional situation that might occur during reading the file,
> parsing the values etc.
