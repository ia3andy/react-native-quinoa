import React from 'react';
import {SectionList, StyleSheet, Text, View, ScrollView} from 'react-native';

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingTop: 22,
    },
    sectionHeader: {
        paddingTop: 2,
        paddingLeft: 10,
        paddingRight: 10,
        paddingBottom: 2,
        fontSize: 14,
        fontWeight: 'bold',
        backgroundColor: '#ffb347',
        color: 'white'
    },
    item: {
        padding: 10,
        fontSize: 18,
        height: 44,
    },
});

const Beers = ({types}) => {
    const data = [];
    for (let {name, beers} of types) {
        data.push({title: name, data: beers});
    }
    return (
        <View style={styles.container}>
            <SectionList
                sections={data}
                renderItem={({item}) => <Text style={styles.item}>{item.name}</Text>}
                renderSectionHeader={({section}) => (
                    <Text style={styles.sectionHeader}>{section.title}</Text>
                )}
                keyExtractor={item => `basicListEntry-${item.id}`}
            />
        </View>
    )
        ;
};

export default Beers;