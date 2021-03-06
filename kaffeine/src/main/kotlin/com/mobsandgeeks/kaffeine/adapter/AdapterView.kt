/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mobsandgeeks.kaffeine.adapter

import android.widget.AdapterView
import android.widget.ListAdapter


inline public fun <reified T> AdapterView<ListAdapter>.onItemClick(
        [inlineOptions(InlineOption.ONLY_LOCAL_RETURN)] listener: (T) -> Unit) {

    this.setOnItemClickListener { adapterView, view, position, id ->
        listener(adapterView.getItemAtPosition(position) as T)
    }
}

inline public fun <reified T> AdapterView<ListAdapter>.onItemClick(
        [inlineOptions(InlineOption.ONLY_LOCAL_RETURN)] listener: (T, Int) -> Unit) {

    this.setOnItemClickListener { adapterView, view, position, id ->
        listener(adapterView.getItemAtPosition(position) as T, position)
    }
}
