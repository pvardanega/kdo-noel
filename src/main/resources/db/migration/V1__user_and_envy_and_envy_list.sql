create table users (
  id bigserial,
  first_name varchar(64) not null,
  last_name varchar(64) not null,
  primary key (id)
);

create table envy_lists (
  id bigserial,
  owner_id bigint not null,
  primary key (id),
  foreign key (owner_id) references users(id)
);

create table envies (
  list_id bigint not null,
  title varchar(64) not null,
  subtitle varchar(64),
  image_url varchar(2048),
  content varchar(2048),
  foreign key (list_id) references envy_lists (id)
);
