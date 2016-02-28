library(dplyr)
bus <- read.delim("bus.txt", header = FALSE)
for (i in 1:10) {
  bus[,i] <- as.POSIXct(bus[,i], format = "%I:%Mam")
}
bus <- bus[,-11]
avgtimes <- rep(0,13)
for (i in 1:13) {
  avgtimes[i] <- mean(as.numeric(bus[i,]))
}



  bus1 <- read.delim("bus1.txt")
  bus1 <- bus1[-1,-1]
  bus1 <- bus1[,-13]
  rownames(bus1) <- 1:nrow(bus1)
  colnames(bus1) <- 1:ncol(bus1)
  for (i in 1:12) {
    bus1[,i] <- as.numeric(as.POSIXct(bus1[,i],format = "%I:%Mam"))
  }
  for (i in 1:10) {
    temp <- bus1[1,11-i]
    bus1[1,13-i] <- temp
  }
  for (i in 1:9) {
    bus1[13, 3+i] <- bus1[13+i, 1]
  }
  bus1 <- bus1[,-1]
  bus1 <- bus1[,-1]
  rownames(bus1) <- 1:nrow(bus1)
  colnames(bus1) <- 1:ncol(bus1)
  avgtimest <- rep(0,13)
  for (i in 1:13) {
    avgtimest[i] <- mean(as.numeric(bus1[i,]))
  }
  avgtimes1 <- avgtimest

