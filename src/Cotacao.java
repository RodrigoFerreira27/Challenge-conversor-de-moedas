public record Cotacao (String result, String base_code, ConversionRates conversion_rates) {
        public record ConversionRates(double USD, double BRL, double ARS, double EUR, double GBP, double CNY) {
    }
}