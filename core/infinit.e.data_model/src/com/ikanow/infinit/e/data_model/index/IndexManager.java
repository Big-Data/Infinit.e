/*******************************************************************************
 * Copyright 2012, The Infinit.e Open Source Project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.ikanow.infinit.e.data_model.index;

import java.util.Collection;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.ikanow.infinit.e.data_model.index.BasePojoIndexMap;

public class IndexManager extends ElasticSearchManager {
	
	//____________________________________________________________________________________
	
	// Index abstraction layer
	
	// Replaces ElasticSeachManager
	
	protected IndexManager() {}
	
	//________________________________________________________________________________________________
	
	// Format conversion
	
	// For non-BaseIndexPojo types (eg BaseDbTypes)
	// Must include a map (but it can be null):
		
	public static<S> JsonElement mapToIndex(S s, BasePojoIndexMap<S> docMap) {
		GsonBuilder gb = BaseIndexPojo.getDefaultBuilder();
		if (null != docMap) {
			gb = docMap.extendBuilder(gb);
		}
		return gb.create().toJsonTree(s);
	}
	public static<S> S mapFromIndex(String s, Class<S> type, BasePojoIndexMap<S> docMap) {
		GsonBuilder gb = BaseIndexPojo.getDefaultBuilder();
		if (null != docMap) {
			gb = docMap.extendBuilder(gb);
		}
		return gb.create().fromJson(s, type);
	}
	@SuppressWarnings("unchecked")
	public static<S> S mapFromIndex(String s, TypeToken<S> type, BasePojoIndexMap<S> docMap) {
		GsonBuilder gb = BaseIndexPojo.getDefaultBuilder();
		if (null != docMap) {
			gb = docMap.extendBuilder(gb);
		}
		return (S)gb.create().fromJson(s, type.getType());
	}
	public static <S> JsonElement mapListToIndex(Collection<S> list, TypeToken<? extends Collection<S>> listType, BasePojoIndexMap<S> docMap) {
		GsonBuilder gb = BaseIndexPojo.getDefaultBuilder();
		if (null != docMap) {
			gb = docMap.extendBuilder(gb);
		}
		return gb.create().toJsonTree(list, listType.getType());
	}
	@SuppressWarnings("unchecked")
	public static <S, L extends Collection<S>> L mapListFromIndex(String json,TypeToken<? extends L> listType, BasePojoIndexMap<S> docMap) {
		GsonBuilder gb = BaseIndexPojo.getDefaultBuilder();
		if (null != docMap) {
			gb = docMap.extendBuilder(gb);
		}
		return (L)gb.create().fromJson(json, listType.getType());
	}		
}