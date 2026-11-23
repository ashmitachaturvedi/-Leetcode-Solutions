// class ProductOfNumbers {
//     int[] stream;
//     int size;
//     public ProductOfNumbers(){
//         stream = new int[40000];
//         size = 0;
//     }
    
//     public void add(int num) {
//         stream[size] = num;
//         size++;
//     }
    
//     public int getProduct(int k) {
//         int product = 1;
//         for(int i = size-k ; i < size ; i++){
//             product *= stream[i];
//         }
//         return product;
//     }
// }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

class ProductOfNumbers {
    ArrayList<Integer> prefixProduct;
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }
    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
            return;
        }
        prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
    }
    public int getProduct(int k) {
        if (prefixProduct.size() <= k) {
            return 0;
        }
        return prefixProduct.get(prefixProduct.size() - 1) / prefixProduct.get(prefixProduct.size() - k - 1);
    }
}