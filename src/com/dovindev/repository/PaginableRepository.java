package com.dovindev.repository;

import com.dovindev.models.Client;

import java.util.List;

public interface PaginableRepository {

    List<Client> getAll(int from, int limit );
}
