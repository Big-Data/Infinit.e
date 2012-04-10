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
package com.ikanow.infinit.e.data_model.store.custom.mapreduce;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.gson.reflect.TypeToken;
import com.ikanow.infinit.e.data_model.store.BaseDbPojo;

public class CustomMapReduceJobPojo extends BaseDbPojo
{
	// Standard static function for readability
	@SuppressWarnings("unchecked")
	static public TypeToken<List<CustomMapReduceJobPojo>> listType() { return new TypeToken<List<CustomMapReduceJobPojo>>(){}; }
	
	public ObjectId _id = null;
	public String jobtitle = null;
	public String jobdesc = null;
	public ObjectId submitterID = null;
	public List<ObjectId> communityIds = null;
	public String jarURL = null;
	public String inputCollection = null;
	public String outputCollection = null;
	public Date lastCompletionTime = null;
	public long nextRunTime = Long.MAX_VALUE;
	public String jobidS = null;
	public int jobidN = 0;
	public SCHEDULE_FREQUENCY scheduleFreq = SCHEDULE_FREQUENCY.NONE;	
	public Date firstSchedule = null;
	public int timesRan = 0;
	public String tempConfigXMLLocation = null;
	public String tempJarLocation = null;
	public boolean isCustomTable = false;
	
	public String mapper;
	public String reducer;
	public String combiner = "";
	public String query = "";
	public String outputKey;
	public String outputValue;
	
	
	public enum SCHEDULE_FREQUENCY
	{
		NONE,
		DAILY,
		WEEKLY,
		MONTHLY;
	}
	
	public enum INPUT_COLLECTIONS
	{	
		IRS_WORKFORCE,
		DOC_METADATA;
	}
}

