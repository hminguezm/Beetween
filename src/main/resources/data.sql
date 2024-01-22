--BRAND_ID  START_DATE           END_DATE              PRICE_LIST   PRODUCT_ID  PRIORITY   PRICE   CURR--
---------------------------------------------------------------------------------------------------------
--1         2020-06-14 00.00.00  2020-12-31-23.59.59   1            35455       0           35.50   EUR
--1         2020-06-14 15.00.00  2020-06-14-18.30.00   2            35455       1           25.45   EUR
--1         2020-06-15 00.00.00  2020-06-15-11.00.00   3            35455       1           30.50   EUR
--1         2020-06-15 16.00.00  2020-12-31-23.59.59   4            35455       1           38.95   EUR

CREATE TABLE IF NOT EXISTS prices (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id BIGINT,
    priority INT,
    price DOUBLE,
    curr VARCHAR(255)
);

INSERT INTO prices ( brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');

INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');

INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');

INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');

SELECT
    PRODUCT_ID,
    BRAND_ID,
    PRICE_LIST,
    START_DATE,
    END_DATE,
    PRICE
FROM
    PRICES
WHERE
    BRAND_ID = 1
    AND PRODUCT_ID = 35455
    AND '2020-06-14 10:00:00' BETWEEN START_DATE AND END_DATE;