package com.ragoju.latest.utils

import com.ragoju.latest.R
import com.ragoju.latest.data.model.GroceryCategorieData
import com.ragoju.latest.data.model.HomeData
import com.ragoju.latest.data.model.NewProductData

class RvData() {


        private var categoryList: MutableList<HomeData> = ArrayList()
        private var dealsList: MutableList<HomeData> = ArrayList()
        private var trendList: MutableList<HomeData> = ArrayList()
        private var bestList: MutableList<HomeData> = ArrayList()
        private var topDealList: MutableList<HomeData> = ArrayList()
        private var notificationList: MutableList<HomeData> = ArrayList()
        private var offersList: MutableList<HomeData> = ArrayList()
        private var cartyoumaylikeList : MutableList<HomeData> = ArrayList()

        private var groceryNewPList : MutableList<NewProductData> = ArrayList()
        private var groceryCategoryList : MutableList<GroceryCategorieData> = ArrayList()
        private var groceryPapularList : MutableList<NewProductData> = ArrayList()


//        private lateinit var categoryList: ArrayList<HomeData>
//        private lateinit var dealsList: ArrayList<HomeData>
//        private lateinit var trendList: ArrayList<HomeData>
//        private lateinit var bestList: ArrayList<HomeData>
//        private lateinit var topDealList: ArrayList<HomeData>
//        private lateinit var notificationList: ArrayList<HomeData>
//        private lateinit var offersList: ArrayList<HomeData>


        fun getCategoryList(): List<HomeData> {
            var category = HomeData(R.drawable.furniture, "Furniture", "", "", "", "")
            categoryList.add(category)
            category = HomeData(R.drawable.furniture, "Fashion", "", "", "", "")
            categoryList.add(category)
            category = HomeData(R.drawable.furniture, "Footware", "", "", "", "")
            categoryList.add(category)
            category = HomeData(R.drawable.furniture, "Grocery", "", "", "", "")
            categoryList.add(category)
            category = HomeData(R.drawable.furniture, "Show all", "", "", "", "")
            categoryList.add(category)
            return categoryList
        }

        fun getDealsList(): List<HomeData> {
            var category =
                HomeData(R.drawable.vegetables, "Grocery items up to 20% Off", "", "", "", "")
            dealsList.add(category)
            category =
                HomeData(R.drawable.vegetables, "Grocery items up to 20% Off", "", "", "", "")
            dealsList.add(category)
            category =
                HomeData(R.drawable.vegetables, "Grocery items up to 20% Off", "", "", "", "")
            dealsList.add(category)
            category =
                HomeData(R.drawable.vegetables, "Grocery items up to 20% Off", "", "", "", "")
            dealsList.add(category)
            category =
                HomeData(R.drawable.vegetables, "Grocery items up to 20% Off", "", "", "", "")
            dealsList.add(category)
            return dealsList
        }

        fun getTrendList(): List<HomeData> {
            var category =
                HomeData(R.drawable.shoe_new, "Up to 50% Off \non Men's Collection", "200", "", "", "Adidas")
            trendList.add(category)
            category =
                HomeData(R.drawable.shoe5, "Up to 50% Off \non Men's Collection", "220", "", "", "Nike")
            trendList.add(category)
            category =
                HomeData(R.drawable.shoe2, "Up to 50% Off \non Men's Collection", "180", "", "", "Rebook")
            trendList.add(category)
            category =
                HomeData(R.drawable.shoe_new, "Up to 50% Off \non Men's Collection", "180", "", "", "Adidas")
            trendList.add(category)
            category =
                HomeData(R.drawable.shoe_new, "Up to 50% Off \non Men's Collection", "180", "", "", "Adidas")
            trendList.add(category)
            return trendList
        }

        fun getBestList(): List<HomeData> {
            var category = HomeData(
                R.drawable.fashion_img,
                "Maroon & Beige Printed Maxi Dress",
                "500",
                "",
                "",
                "Deewa",

            )
            bestList.add(category)
            category = HomeData(
                R.drawable.fashion_2,
                "Women Cateye SunGlass",
                "500",
                "",
                "",
                "RARE Vibes"
            )
            bestList.add(category)
            category = HomeData(
                R.drawable.fashion_3,
                "Cateye Sunglasses",
                "500",
                "",
                "",
                "Cateye Glass"
            )
            bestList.add(category)
            category = HomeData(
                R.drawable.fashion_4,
                "Unisex Aviator Sunglasses",
                "500",
                "",
                "",
                "ROYAL SON"
            )
            bestList.add(category)
            category = HomeData(
                R.drawable.bn,
                "Accordian Pleats A-Line Dress",
                "500",
                "",
                "",
                "SASSAFRAS"
            )
            bestList.add(category)
            return bestList
        }

        fun getTopDealList(): List<HomeData> {
            var category = HomeData(R.drawable.headphne, "Noise Ear Budss", "1600", "", "", "")
            topDealList.add(category)
            category = HomeData(R.drawable.headphone, "Noise Ear Budss", "1600", "", "", "")
            topDealList.add(category)
            category = HomeData(R.drawable.headset, "Noise Ear Budss", "1600", "", "", "")
            topDealList.add(category)
            category = HomeData(R.drawable.headphone, "Noise Ear Budss", "1600", "", "", "")
            topDealList.add(category)
            category = HomeData(R.drawable.headphone, "Noise Ear Budss", "1600", "", "", "")
            topDealList.add(category)
            return topDealList
        }

        fun getNotificationList(): List<HomeData> {
            var category = HomeData(
                R.drawable.sale,
                "Biggest Offers On Mobiles!",
                "",
                "",
                "",
                "Best Selling Mobiles at lowest\nPrice Avail 10% instant Discount \non HDFC Cards. only till Dec  5th"
            )
            notificationList.add(category)
            category = HomeData(
                R.drawable.sale,
                "Biggest Offers On Mobiles!",
                "",
                "",
                "",
                "Best Selling Mobiles at lowest\nPrice Avail 10% instant Discount \non HDFC Cards. only till Dec  5th"
            )
            notificationList.add(category)
            category = HomeData(
                R.drawable.sale,
                "Biggest Offers On Mobiles!",
                "",
                "",
                "",
                "Best Selling Mobiles at lowest\nPrice Avail 10% instant Discount \non HDFC Cards. only till Dec  5th"
            )
            notificationList.add(category)
            return notificationList
        }

        fun getOffersList(): MutableList<HomeData> {
            var category =
                HomeData(R.drawable.offer_img, "50% Of on Electronic Products", "", "", "", "")
            offersList.add(category)
            category =
                HomeData(R.drawable.offer_img, "50% Of on Electronic Products", "", "", "", "")
            offersList.add(category)
            category =
                HomeData(R.drawable.offer_img, "50% Of on Electronic Products", "", "", "", "")
            offersList.add(category)

            return offersList
        }

        fun getCartYMLList(): MutableList<HomeData> {

            var category = HomeData(R.drawable.shoe_new, "Nike", "$200", "", "", "")
           cartyoumaylikeList.add(category)
            category = HomeData(R.drawable.fashion_2, "Women Cateye SunGlass", "$500", "", "", "RARE Vibes")
            cartyoumaylikeList.add(category)
            category = HomeData(R.drawable.headphone, "Noise Ear Budss", "$215", "", "", "")
            cartyoumaylikeList.add(category)
            category = HomeData(R.drawable.headphone, "Noise Ear Budss", "$220", "", "", "")
            cartyoumaylikeList.add(category)


            return cartyoumaylikeList
        }

        fun newproductList() : List<NewProductData> {
            var category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"", "", "10%","")
            groceryNewPList.add(category)
            category = NewProductData("","Banana", "1 kg",  "Rs", "20", R.drawable.banana,"","","20%","")
            groceryNewPList.add(category)
            category = NewProductData("","Litche", "1 kg",  "Rs", "20", R.drawable.straberry,"","","10%","")
            groceryNewPList.add(category)
            category = NewProductData("","House Clean Liquid", "1 Lit",  "Rs", "20", R.drawable.cleanhouse,"","","20%","")
            groceryNewPList.add(category)
            category = NewProductData("","Pampers","1 peice", "Rs",  "20", R.drawable.pampers,"","","10%","")
            groceryNewPList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","20%","")
            groceryNewPList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","15%","")
            groceryNewPList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","","")
            groceryNewPList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","","")
            groceryNewPList.add(category)

            return groceryNewPList


        }



     fun grocerycategorieDataList() : List<GroceryCategorieData> {
            var category = GroceryCategorieData("Food")
            groceryCategoryList.add(category)
            category = GroceryCategorieData("Home & Cleaning")
            groceryCategoryList.add(category)
            category = GroceryCategorieData("Baby Care")
            groceryCategoryList.add(category)
            category = GroceryCategorieData("sports & Nutrition")
            groceryCategoryList.add(category)
            category = GroceryCategorieData("Pet care")
            groceryCategoryList.add(category)
            category = GroceryCategorieData("Health & Household")
            groceryCategoryList.add(category)

            return groceryCategoryList
        }

     fun popularProductData() : List<NewProductData> {

            var category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"", "", "20%","")
            groceryPapularList.add(category)
            category = NewProductData("","Banana", "1 kg",  "Rs", "20", R.drawable.banana,"","","10%","")
            groceryPapularList.add(category)
            category = NewProductData("","Litche", "1 kg",  "Rs", "20", R.drawable.straberry,"","","10%","")
            groceryPapularList.add(category)
            category = NewProductData("","House Clean Liquid", "1 Lit",  "Rs", "20", R.drawable.cleanhouse,"","","20%","")
            groceryPapularList.add(category)
            category = NewProductData("","Pampers","1 peice", "Rs",  "20", R.drawable.pampers,"","","10%","")
            groceryPapularList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","10%","")
            groceryPapularList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","15%","")
            groceryPapularList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","10","")
            groceryPapularList.add(category)
            category = NewProductData("","Apple", "1 kg",  "Rs", "20", R.drawable.apple,"","","10%","")
            groceryPapularList.add(category)

            return groceryPapularList

        }
}