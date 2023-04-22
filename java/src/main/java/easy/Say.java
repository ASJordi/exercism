package easy;

public class Say {

    private static final String[] small = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "ones", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninty"
    };

    private static final String[] scale = {
            "thousand", "million", "billion",
            "trillion", "quadrillion", "quintillion"
    };

    public String say(final long number)
    {
        if (number >= 1_000_000_000_000L) throw new IllegalArgumentException();

        if (number < 0) throw new IllegalArgumentException();

        if (number < 20) return small[(int) number];


        if (number < 100) {
            var ten = tens[(int) (number / 10)];
            if (number % 10 > 0)
            {
                ten += "-" + small[(int) (number % 10)];
            }
            return ten;
        }

        if (number < 1000) {
            var hundred = small[(int) (number / 100)] + " hundred";
            if (number % 100 > 0)
            {
                hundred += " " + say(number % 100);
            }
            return hundred;
        }

        var result = "";
        var big = number;

        if (big % 1000 > 0) {
            result = say(big % 1000);
        }

        for (var i = 0; i <= 5; ++i) {
            big /= 1000;

            if (big % 1000 > 0) {
                var scaled = say(big % 1000) + " " + scale[i];

                if (!result.isEmpty()) {
                    scaled += ' ' + result;
                }

                result = scaled;
            }
        }

        return result;
    }

}
