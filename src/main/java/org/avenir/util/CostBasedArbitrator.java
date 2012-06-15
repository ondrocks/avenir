/*
 * avenir: Predictive analytic based on Hadoop Map Reduce
 * Author: Pranab Ghosh
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */


package org.avenir.util;

public class CostBasedArbitrator {
	private String posClass;
	private String negClass;
	private int falseNegCost;
	private int falsePosCost;
	
	public CostBasedArbitrator(String posClass, String negClass,
			int falseNegCost, int falsePosCost) {
		this.posClass = posClass;
		this.negClass = negClass;
		this.falseNegCost = falseNegCost;
		this.falsePosCost = falsePosCost;
	}
	
	public String arbitrate(int posProb, int negProb) {
		int negCost = falseNegCost * posProb;
		int posCost = falsePosCost * negProb;
		String predClass =  posCost < negCost  ? posClass : negClass;
		return predClass;
	}
}
