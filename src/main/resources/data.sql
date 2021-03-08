insert into USER (userName, password, dob, level, qualifcation) values('user1@test.com', 'cGFzc3dvcmQ=', '08-Mar-1990', 'L1', 'BE');
insert into USER (userName, password, dob, level, qualifcation) values('user2@test.com', 'cGFzc3dvcmQ=', '08-Mar-1991', 'L2', 'BE');

insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-1', 'User-1 Product', '<10', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 1, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-2', 'User-1 Product', '10-20', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 1, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-3', 'User-1 Product', '20-30', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 1, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-4', 'User-1 Product', '30-40', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 1, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-5', 'User-1 Product', '40-50', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 1, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-6', 'User-1 Product', '50>', {ts '2021-09-17 18:47:52.69'}, 'OUT OF STOCK', 1, false);

insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-1', 'User-2 Product', '<10', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 2, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-2', 'User-2 Product', '10-20', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 2, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-3', 'User-2 Product', '20-30', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 2, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-4', 'User-2 Product', '30-40', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 2, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-5', 'User-2 Product', '40-50', {ts '2021-09-17 18:47:52.69'}, 'INSTOCK', 2, true);
insert into PRODUCT (PRODUCT_NAME, PRODUCT_DEC, AGE_CRITERIA, EXPIRE_DT,STATUS,USER_USER_ID, IS_AVAILABLE) values('Product-6', 'User-1 Product', '50>', {ts '2021-09-17 18:47:52.69'}, 'OUT OF STOCK', 2, false);
