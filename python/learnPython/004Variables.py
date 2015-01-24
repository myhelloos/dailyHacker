# -*- coding: utf-8 -*-
# 车辆总数
cars = 100 
# 容载量
sapce_in_a_car = 4.0
# 司机数
drivers = 30
# 乘客数
passengers = 90
# 无法运载的车辆 = 当前车辆总数 - 司机数
cars_not_driven = cars - drivers
# 可以运载的车辆 = 司机数
cars_driven = drivers
# 总容载量 = 容载量 * 可以运载的车辆
carpool_capacity = cars_driven * sapce_in_a_car
# 平均每辆车的载客量 = 乘客数 / 可以运载的车辆
average_passengers_per_car = passengers / cars_driven


print "There are", cars, "cars available."
print "There are only", drivers, "drivers available."
print "There will be", cars_not_driven, "empty cars today."
print "We can transport", carpool_capacity, "people today."
print "We have", passengers, "to carpool today."
print "We need to put about", average_passengers_per_car, "in each car."

