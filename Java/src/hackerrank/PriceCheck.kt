package hackerrank

/**
 * Created by dastaniqbal on 09/07/2019.
 * ask2iqbal@gmail.com
 * 09/07/2019 10:45
 */


/*
 * Complete the 'hackerrank.priceCheck' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING_ARRAY products
 *  2. FLOAT_ARRAY productPrices
 *  3. STRING_ARRAY productSold
 *  4. FLOAT_ARRAY soldPrice
 */

fun priceCheck(products: Array<String>, productPrices: Array<Float>, productSold: Array<String>, soldPrice: Array<Float>): Int {
    var wrongPrice = 0
    productSold.forEachIndexed { index, s ->
        val productIndex=products.indexOf("s")
        val productPrice = productPrices[productIndex]
        if (productPrice != soldPrice[index])
            wrongPrice++
    }
    return wrongPrice
}

fun main(args: Array<String>) {
    val productsCount = readLine()!!.trim().toInt()

    val products = Array<String>(productsCount, { "" })
    for (i in 0 until productsCount) {
        val productsItem = readLine()!!
        products[i] = productsItem
    }

    val productPricesCount = readLine()!!.trim().toInt()

    val productPrices = Array<Float>(productPricesCount, { 0f })
    for (i in 0 until productPricesCount) {
        val productPricesItem = readLine()!!.trim().toFloat()
        productPrices[i] = productPricesItem
    }

    val productSoldCount = readLine()!!.trim().toInt()

    val productSold = Array<String>(productSoldCount, { "" })
    for (i in 0 until productSoldCount) {
        val productSoldItem = readLine()!!
        productSold[i] = productSoldItem
    }

    val soldPriceCount = readLine()!!.trim().toInt()

    val soldPrice = Array<Float>(soldPriceCount, { 0f })
    for (i in 0 until soldPriceCount) {
        val soldPriceItem = readLine()!!.trim().toFloat()
        soldPrice[i] = soldPriceItem
    }

    val result = priceCheck(products, productPrices, productSold, soldPrice)

    println(result)
}