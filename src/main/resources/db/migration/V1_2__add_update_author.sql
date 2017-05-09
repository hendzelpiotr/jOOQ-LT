CREATE OR REPLACE FUNCTION update_author(
  id            INTEGER,
  first_name    VARCHAR(50) DEFAULT NULL,
  last_name     VARCHAR(50) DEFAULT NULL,
  date_of_birth TIMESTAMP DEFAULT NULL,
  address       VARCHAR(50) DEFAULT NULL
)
  RETURNS BOOLEAN LANGUAGE plpgsql SECURITY DEFINER AS $$

BEGIN
  UPDATE author
  SET first_name  = COALESCE(update_author.first_name, author.first_name),
    last_name     = COALESCE(update_author.last_name, author.last_name),
    date_of_birth = COALESCE(update_author.date_of_birth, author.date_of_birth),
    address       = COALESCE(update_author.address, author.address)
  WHERE author.id = update_author.id;
  RETURN FOUND;
END;
$$;