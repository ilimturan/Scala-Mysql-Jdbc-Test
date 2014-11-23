CREATE TABLE `books` (
    `id` int(11) NOT NULL,
    `isbn` int(11) NOT NULL,
    `name` varchar(255) NOT NULL,
    `date` datetime NOT NULL
  ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

  --
  -- Dumping data for table `books`
    --

  INSERT INTO `books` (`id`, `isbn`, `name`, `date`) VALUES
    (1, 2147483647, 'Scala Cookbook', '2014-11-05 00:00:00'),
  (2, 35345345, 'Scala In Action', '2014-11-04 07:24:31');