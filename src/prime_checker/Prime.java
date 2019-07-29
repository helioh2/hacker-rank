package prime_checker;


class Prime {

    private boolean isPrime(int a) {
        if (a == 1) return false;
        for (int i = 2; i < a / 2 + 1; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void checkPrime(int... ns) {
        String result = "";
        for (int n : ns) {
            if (isPrime(n)) {
                result += n + " ";
            }
        }
//        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }

}

